package com.kaparzh.service;

import com.kaparzh.model.File;

public interface FileService extends GenericService<File, Integer> {

    File create(String name, String filepath);

    File update(Integer id, String name, String filepath);
}
