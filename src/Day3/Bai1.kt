package Day3


// Hàm main để kiểm tra
fun main() {
    val nv1 = NhanVien("", "", 0) // Tạo nhân viên 1
    val nv2 = NhanVien("", "", 0) // Tạo nhân viên 2

    println("Nhập thông tin nhân viên 1:")
    nv1.nhapThongTin()

    println("\nNhập thông tin nhân viên 2:")
    nv2.nhapThongTin()

    // Xuất thông tin lương của từng nhân viên
    println("\nThông tin nhân viên 1:")
    nv1.hienThiThongTin()

    println("\nThông tin nhân viên 2:")
    nv2.hienThiThongTin()

    // So sánh số sản phẩm dùng hàm lonHon
    if (nv1.lonHon(nv2)) {
        println("\nNhân viên ${nv1.getHo()} ${nv1.getTen()} có số sản phẩm nhiều hơn nhân viên ${nv2.getHo()} ${nv2.getTen()} là ${nv1.getSoSP() - nv2.getSoSP()} sản phẩm.")
    } else if (nv2.lonHon(nv1)) {
        println("\nNhân viên ${nv2.getHo()} ${nv2.getTen()} có số sản phẩm nhiều hơn nhân viên ${nv1.getHo()} ${nv1.getTen()} là ${nv2.getSoSP() - nv1.getSoSP()} sản phẩm.")
    } else {
        println("\nCả hai nhân viên có số sản phẩm bằng nhau.")
    }
}


