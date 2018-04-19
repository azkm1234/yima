package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import domain.AuctionHorseMapper;
import domain.FineHorseOnSaleMapper;
import domain.RecommendHorseMapper;
import model.AuctionHorse;
import model.AutionResult;
import model.FineHorseOnSale;
import model.FineResult;
import model.RecommendHorse;
import model.RecommendResult;
import serviceinterface.ThreeHorseService;
@Service(value = "threeHorseService")
public class ThreeHorseServiceImpl implements ThreeHorseService {
	@Resource(name = "auctionHorseMapper")
	AuctionHorseMapper auctionHorseMapper;
	@Resource(name = "fineHorseOnSaleMapper")
	FineHorseOnSaleMapper fineHorseOnSaleMapper;
	@Resource(name = "recommendHorseMapper")
	RecommendHorseMapper recommendHorseMapper;
	@Override
	public List<AutionResult> findAuctionHorse(int currenPage, int pageSize) {
		PageHelper.startPage(currenPage, pageSize);
		List<AutionResult> lists = this.auctionHorseMapper.selectBySize();
		return lists;
	}

	@Override
	public List<FineResult> findFineHorseOnSale(int currenPage, int pageSize) {
		PageHelper.startPage(currenPage, pageSize);
		List<FineResult>lists = this.fineHorseOnSaleMapper.selectBySize();
		return lists;
	}

	@Override
	public List<RecommendResult> findRecommendHorse(int currenPage, int pageSize) {
		PageHelper.startPage(currenPage, pageSize);
		List<RecommendResult> lists = this.recommendHorseMapper.selectBySize();
		return lists;
	}

	@Override
	public void update(AuctionHorse horse) throws Exception {
		this.auctionHorseMapper.updateByPrimaryKeySelective(horse);
	}

	@Override
	public void update(FineHorseOnSale horse) throws Exception {
		this.fineHorseOnSaleMapper.updateByPrimaryKeySelective(horse);
	}

	@Override
	public void update(RecommendHorse horse) throws Exception {
		this.recommendHorseMapper.updateByPrimaryKeySelective(horse);
	}

	@Override
	public void deleteAuctionHorse(int horseId) throws Exception {
		this.auctionHorseMapper.deleteByHorseId(horseId);
	}

	@Override
	public void deleteFineHorse(int horseId) throws Exception {
		this.fineHorseOnSaleMapper.deleteByHorseId(horseId);
	}

	@Override
	public void deleteRecommendHorse(int horseId) throws Exception {
		this.recommendHorseMapper.deleteByHorseId(horseId);
	}

	@Override
	public void addAuctionHorse(AuctionHorse horse) {
		this.auctionHorseMapper.insertSelective(horse);
	}

	@Override
	public void addFineHorse(FineHorseOnSale horse) {
		this.fineHorseOnSaleMapper.insertSelective(horse);
	}

	@Override
	public void addRecommendHorse(RecommendHorse horse) {
		this.recommendHorseMapper.insertSelective(horse);
	}

}
