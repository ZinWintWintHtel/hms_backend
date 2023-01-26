package com.hostmdy.hms.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.hms.domain.Asset;
import com.hostmdy.hms.repository.AssetRepository;
import com.hostmdy.hms.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService{
	
	private final AssetRepository assetRepository;

	@Autowired
	public AssetServiceImpl(AssetRepository assetRepository) {
		super();
		this.assetRepository = assetRepository;
	}

	@Override
	public Asset saveOrUpdateAsset(Asset asset) {
		// TODO Auto-generated method stub
		return assetRepository.save(asset);
	}

}
