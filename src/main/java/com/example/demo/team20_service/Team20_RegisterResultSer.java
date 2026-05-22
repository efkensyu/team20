package com.example.demo.team20_service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20_entity.Team20_Hobby;
import com.example.demo.team20_entity.Team20_Shain;
import com.example.demo.team20_repository.Team20_HobbyRepository;
import com.example.demo.team20_repository.Team20_RegisterResultRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team20_RegisterResultSer {

	private final Team20_RegisterResultRepository shainrepository;

	private final Team20_HobbyRepository hobbyrepository;

	//マッチングスコアを計算し降順ソートした社員リストを返す。

	public List<Team20_Shain> getMatchingResult(Team20_Shain me) {

		// 自分以外の全社員取得
		List<Team20_Shain> candidates = shainrepository.findAllExcludeSelf(me.getShainCd());

		// 自分のHobby情報を事前に取得（DBアクセスを最小化）
		Team20_Hobby myHobby1 = findHobby(me.getRank1());
		Team20_Hobby myHobby2 = findHobby(me.getRank2());
		Team20_Hobby myHobby3 = findHobby(me.getRank3());

		// スコア計算
		List<ShainScore> scoreList = new ArrayList<>();
		for (Team20_Shain other : candidates) {
			Team20_Hobby otherHobby1 = findHobby(other.getRank1());
			Team20_Hobby otherHobby2 = findHobby(other.getRank2());
			Team20_Hobby otherHobby3 = findHobby(other.getRank3());

			int score = calcScore(
					me, other,
					myHobby1, myHobby2, myHobby3,
					otherHobby1, otherHobby2, otherHobby3);
			other.setTotalScore(score); // Transientフィールドにセット
			scoreList.add(new ShainScore(other, score));
		}

		// 降順ソート（同点は社員CD昇順）
		scoreList.sort(Comparator
				.comparingInt(ShainScore::getScore).reversed()
				.thenComparing(ss -> ss.getShain().getShainCd()));

		// Shainリストに変換
		List<Team20_Shain> result = new ArrayList<>();
		for (ShainScore ss : scoreList) {
			result.add(ss.getShain());
		}

		return result;
	}

	//スコア計算メイン
	private int calcScore(
			Team20_Shain me, Team20_Shain other,
			Team20_Hobby myH1, Team20_Hobby myH2, Team20_Hobby myH3,
			Team20_Hobby otH1, Team20_Hobby otH2, Team20_Hobby otH3) {

		int score = 0;

		// 配列化（1位=0, 2位=1, 3位=2）
		Team20_Hobby[] myHobbies = { myH1, myH2, myH3 };
		Team20_Hobby[] otHobbies = { otH1, otH2, otH3 };

		// ----【判定1】IT分野（job）一致：+30点 ----
		if (isNotEmpty(me.getJob()) && me.getJob().equals(other.getJob())) {
			score += 30;
		}

		// 同順位で趣味名が完全一致したか記録（判定3の二重カウント防止）
		boolean[] sameRankMatch = new boolean[3];

		// ----【判定2】同順位同士の比較 ----
		for (int i = 0; i < 3; i++) {
			Team20_Hobby my = myHobbies[i];
			Team20_Hobby ot = otHobbies[i];

			if (my == null || ot == null)
				continue;

			if (my.getHobby().equals(ot.getHobby())) {
				// 趣味名が完全一致
				// パターン①：1位完全一致 +150点
				// パターン②：2・3位完全一致 +100点
				score += (i == 0) ? 150 : 100;
				sameRankMatch[i] = true;

			} else if (isNotEmpty(my.getJanru()) && my.getJanru().equals(ot.getJanru())) {
				// ジャンルのみ一致
				// パターン④：1位ジャンル一致 +40点
				// パターン⑤：2・3位ジャンル一致 +20点
				score += (i == 0) ? 40 : 20;
			}
		}

		// ----【判定3】クロスチェック（順位ズレ）：+70点 ----
		for (int i = 0; i < 3; i++) {
			if (myHobbies[i] == null)
				continue;
			if (sameRankMatch[i])
				continue; // 同順位で完全一致済みはスキップ

			for (int j = 0; j < 3; j++) {
				if (i == j)
					continue; // 同順位は判定2で処理済み
				if (otHobbies[j] == null)
					continue;
				if (sameRankMatch[j])
					continue; // 相手の完全一致済み枠はスキップ

				if (myHobbies[i].getHobby().equals(otHobbies[j].getHobby())) {
					score += 70;
					break; // 1つの趣味につき1回のみ加算
				}
			}
		}

		// 【判定4】0点のまま → パターン⑥不一致（加算なし）
		return score;
	}

	//ユーティリティ

	private Team20_Hobby findHobby(String hobbyCd) {
		if (!isNotEmpty(hobbyCd))
			return null;
		return hobbyrepository.findById(hobbyCd).orElse(null);

	}

	private boolean isNotEmpty(String str) {
		return str != null && !str.isEmpty();
	}

	private static class ShainScore {
		private final Team20_Shain shain;
		private final int score;

		public ShainScore(Team20_Shain shain, int score) {
			this.shain = shain;
			this.score = score;
		}

		public Team20_Shain getShain() {
			return shain;
		}

		public int getScore() {
			return score;
		}
	}

}
