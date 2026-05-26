package com.example.demo.team20.team20_service;

import org.springframework.stereotype.Service;

import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_repository.Team20_DetailsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class Team20_DetailsService {
	private final Team20_DetailsRepository repository;

	public Team20_Shain findPerson(String shainCd) {
		log.info("[DetailsService開始] 社員情報の詳細検索を開始します。 社員コード: {}", shainCd);

		Team20_Shain shain = repository.findById(shainCd).orElse(null);
		if (shain != null) {
			log.info("[DetailsService] 社員情報を検知。続いて趣味の名称変換処理を行います。");
			log.info("  [変換前コード] rank1: {}, rank2: {}, rank3: {}", shain.getRank1(), shain.getRank2(),
					shain.getRank3());

			String h1 = repository.findHobbyname(shain.getRank1());
			String h2 = repository.findHobbyname(shain.getRank2());
			String h3 = repository.findHobbyname(shain.getRank3());
			shain.setRank1(h1);
			shain.setRank2(h2);
			shain.setRank3(h3);

			log.info("  [変換後名称] rank1: {}, rank2: {}, rank3: {}", h1, h2, h3);
		} else {//追加
			log.warn("[DetailsService警告] 該当する社員が存在しません。 社員コード: {}", shainCd);
		}

		log.info("[DetailsService終了] 詳細検索処理が正常に完了しました。");
		return shain;
	}

}
