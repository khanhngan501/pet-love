package com.stc.petlove.dto.responseDTO;

import com.stc.petlove.entities.embedded.ThongTinDatCho;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class DatChoResponse {
    private String id;

    // email người đặt chỗ
    private String email;

    private List<ThongTinDatCho> thongTinDatChos = new ArrayList<>();

    // Thời gian chăm sóc thú cưng
    private Date thoiGian;

    // căn dặn khi chăm sóc thú cưng
    private String canDan;

    // lấy từ enum trạng thái đặt chỗ
    private String trangThaiDatCho;

    private boolean trangThai = true;

    public DatChoResponse(String id, String email, List<ThongTinDatCho> thongTinDatChos, Date thoiGian, String canDan, String trangThaiDatCho, boolean trangThai) {
        this.id = id;
        this.email = email;
        this.thongTinDatChos = thongTinDatChos;
        this.thoiGian = thoiGian;
        this.canDan = canDan;
        this.trangThaiDatCho = trangThaiDatCho;
        this.trangThai = trangThai;
    }
}
