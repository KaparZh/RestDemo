package com.kaparzh.service.impl;

import com.kaparzh.model.File;
import com.kaparzh.repository.impl.FileRepositoryImpl;
import com.kaparzh.service.FileService;

import java.util.List;

public final class FileServiceImpl implements FileService {

    private static final FileServiceImpl INSTANCE = new FileServiceImpl();

    private final FileRepositoryImpl fileRepository = FileRepositoryImpl.getInstance();

    private FileServiceImpl() {
    }

    public static FileServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public File create(String name, String filepath) {
        return fileRepository.save(new File(name, filepath));
    }

    @Override
    public File update(Integer id, String name, String filepath) {
        return fileRepository.update(new File(id, name, filepath));
    }

    @Override
    public File getById(Integer id) {
        return fileRepository.getById(id);
    }

    @Override
    public void delete(Integer id) {
        fileRepository.deleteById(id);
    }

    @Override
    public List<File> getAll() {
        return fileRepository.getAll();
    }
}
