package com.pixel.pixelproject.Controller;

public interface ApiPath {

    String ADMIN = "/admin";
    String ROOT="/api";

    String ID = "id";
    String NAME = "name";
    String PRODUCTS = "/products";
    String PRODUCT = "/{" + ID + "}";
    String SEARCH = "/search";
    String FILES = "/files";
    String FILE_BY_NAME = "/{" + NAME + "}";
    String BLOBS = "/blobs";
    String GET_BLOB = BLOBS + "/{" + ID + "}";
    String PIXELSIZES="/pixelsizes";
}
