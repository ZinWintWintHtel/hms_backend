package com.hostmdy.hms.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.hms.domain.Asset;
import com.hostmdy.hms.service.AssetService;

@RestController
@RequestMapping("/api/asset")
public class AssetController {
	
	private final AssetService assetService;

	public AssetController(AssetService assetService) {
		super();
		this.assetService = assetService;
	}
	 
	@PostMapping("/create")
	public ResponseEntity<Asset> createAsset(@RequestBody Asset asset){
		
		Asset createdAsset = assetService.saveOrUpdateAsset(asset);
		
		return new ResponseEntity<Asset>(createdAsset,HttpStatus.CREATED);
		
	}

}