package com.pixel.pixelproject.Controller;

public interface ApiPath {

    String ADMIN = "/admin";
    String ROOT="/";

    String ID_VARIABLE = "id";
    String NAME_VARIABLE = "name";
    String PRODUCTS = "/products";
    String PRODUCT = "/{" + ID_VARIABLE + "}";
    String SEARCH = "/search";
    String FILES = "/files";
    String FILE_BY_NAME = "/{" + NAME_VARIABLE + "}";
    String BLOBS = "/blobs";
    String GET_BLOB = BLOBS + "/{" + ID_VARIABLE + "}";
}
