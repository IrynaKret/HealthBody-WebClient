package edu.softserveinc.healthbody.webclient.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.softserveinc.healthbody.webclient.dto.StatisticsDTO;
import edu.softserveinc.healthbody.webclient.dto.StatisticsMapper;
import edu.softserveinc.healthbody.webclient.entity.Statistics;
import edu.softserveinc.healthbody.webclient.repository.StatisticsRepository;
import edu.softserveinc.healthbody.webclient.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	
	@Autowired
	private StatisticsRepository statisticsRepository;

	@Override
	@Transactional
	public void addStatistics(StatisticsDTO statisticsDTO) {
		Statistics statistics = new Statistics();
		StatisticsMapper.toEntity(statisticsDTO, statistics);
		statisticsRepository.save(statistics);
	}

	@Override
	@Transactional
	public List<String> getAllUsersLogin() {
		return statisticsRepository.getAllUsers();
	}

	@Override
	@Transactional
	public List<StatisticsDTO> getStatisticsByUserLogin(String userLogin) {
		List<StatisticsDTO> statisticsList= new ArrayList<>();
		for(Statistics statistics : statisticsRepository.findByUserLogin(userLogin)) {
			StatisticsDTO statisticsDTO = new StatisticsDTO();
			statisticsList.add(StatisticsMapper.toDto(statisticsDTO, statistics));
		}
		return statisticsList;
	}
	
	@Override
	@Transactional
	public void updateStatistics(Date logoutDate, String userLogin) {
		statisticsRepository.updateStatistics(logoutDate, userLogin);
	}

	@Override
	public Integer getUserStatisticsPerDate(String userLogin, String likeDate) {
		return statisticsRepository.getCountLoginUserPerDate(userLogin, likeDate);
	}
	
	@Override
	public StatisticsDTO getUserForUpdate(String userLogin) {
		StatisticsDTO statisticsDTO = new StatisticsDTO();
		Statistics statistics = statisticsRepository.findUserForUpdate(userLogin);
		if (statistics != null) {
			StatisticsMapper.toDto(statisticsDTO, statistics);
			return statisticsDTO;
		} else {
			return null;
		}
	}
}
