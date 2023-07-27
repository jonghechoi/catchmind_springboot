package com.springboot.catchmind.jpa.repositoryimpl;

import org.springframework.data.domain.Pageable;

public class PageRequest {
    // paging execution needs page : member, notice, review
    private int page = 1;
    private int size = 5;
    private String serviceName;

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public org.springframework.data.domain.PageRequest of() {
        return org.springframework.data.domain.PageRequest.of(page, size);
    }
}
