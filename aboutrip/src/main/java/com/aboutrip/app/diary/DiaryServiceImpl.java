package com.aboutrip.app.diary;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aboutrip.app.common.FileManager;
import com.aboutrip.app.common.dao.AboutDAO;

@Service("diary.diaryServiceImpl")
public class DiaryServiceImpl implements DiaryService {
	@Autowired
	private AboutDAO dao;
	
	@Autowired
	private FileManager fileManager;

	@Override
	public void insertDiary(Diary dto, String pathname) throws Exception {
		/*
		for(MultipartFile mf : dto.getUpload()) {
			try {
				
				String saveImgName = fileManager.doFileUpload(dto.getUpload(), pathname);
				if(saveImgName != null) {
					dto.getSavePathname().add(pathname+File.separator+saveImgName);
					String originalImgName = mf.getOriginalFilename();
					dto.setSaveImgName(dto.getUpload().get);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		try {
			String diaryImgNum = fileManager.doFileUpload(dto.getUpload(), pathname);
			if(diaryImgNum != null) {
				dto.setDiaryImgNum(diaryImgNum);
				dto.setDiaryImgName(dto.getUpload().getOriginalFilename());
			}
			dao.insertData("diary.insertDiary", dto);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		*/
	}

	@Override
	public int dataCount(Map<String, Object> map) {
		
		return 0;
	}

	@Override
	public List<Diary> listDiary(Map<String, Object> map) {
		List<Diary> list = null;
		
		try {
			list = dao.selectList("diary.listDiary", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Diary readDiary(int diaryNum) {
		
		return null;
	}

	@Override
	public void updateDiary(Diary dto, String pathname) throws Exception {
		
	}

	@Override
	public void deleteDiary(int diaryNum, String pathname) throws Exception {
		
	}

	@Override
	public void insertDiaryLike(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int diaryLikeCount(int diaryNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isDiaryLikeUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int DiaryLikeDelete(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
