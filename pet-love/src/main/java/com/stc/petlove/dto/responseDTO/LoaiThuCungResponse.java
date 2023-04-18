package com.stc.petlove.dto.responseDTO;

import lombok.Data;

@Data
public class LoaiThuCungResponse {
    private String id;

    private String maLoaiThuCung;

    private String tenLoaiThuCung;

    private boolean trangThai;

    public LoaiThuCungResponse(String id, String maLoaiThuCung, String tenLoaiThuCung, boolean trangThai) {
        this.id = id;
        this.maLoaiThuCung = maLoaiThuCung;
        this.tenLoaiThuCung = tenLoaiThuCung;
        this.trangThai = trangThai;
    }
}
