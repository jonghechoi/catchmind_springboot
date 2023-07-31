package com.springboot.catchmind.jpa.repositoryimpl;

import org.springframework.data.domain.Pageable;

public class PageRequest {
    // paging execution needs page : member, notice, review
    private int page = 1;
    private int sizeMember = 7;
    private int sizeNotice = 5;
    private int sizeReview = 3;
    private String serviceName;

    public void setPage(int page) {
        this.page = page;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public org.springframework.data.domain.PageRequest of() {
        int size = 0;
        if(serviceName.equals("member")) {
            size = sizeMember;
        } else if (serviceName.equals("notice")) {
            size = sizeNotice;
        } else if (serviceName.equals("review")) {
            size = sizeReview;
        }
        return org.springframework.data.domain.PageRequest.of(page, size);
    }
}
