package edu.softserveinc.healthbody.webclient.dto;

import edu.softserveinc.healthbody.webclient.entity.Statistics;

public class StatisticsMapper {
	
	public static Statistics toEntity(StatisticsDTO statisticsDTO, Statistics statistics) {
		statistics.setUserLogin(statisticsDTO.getUserLogin());
		statistics.setLoginDate(statisticsDTO.getLoginDate());
		statistics.setLogoutDate(statisticsDTO.getLogoutDate());
		return statistics;
	}
	
	public static StatisticsDTO toDto(StatisticsDTO statisticsDTO, Statistics statistics) {
		statisticsDTO.setId(String.valueOf(statistics.getId()));
		statisticsDTO.setUserLogin(statistics.getUserLogin());
		statisticsDTO.setLoginDate(statistics.getLoginDate());
		statisticsDTO.setLogoutDate(statistics.getLogoutDate());
		return statisticsDTO;
	}
}
