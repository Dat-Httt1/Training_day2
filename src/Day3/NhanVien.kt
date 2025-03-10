package Day3

class NhanVien(private var ho: String, private var ten: String, private var soSP: Int) {
    init {
        if (soSP < 0) {
            soSP = 0
        }
    }

    fun getHo(): String = ho
    fun setHo(ho: String) {
        this.ho = ho
    }

    fun getTen(): String = ten
    fun setTen(ten: String) {
        this.ten = ten
    }

    fun getSoSP(): Int = soSP
    fun setSoSP(soSP: Int) {
        this.soSP = if (soSP < 0) 0 else soSP
    }


    fun getLuong(): Double {
        val donGia = when {
            soSP in 1 .. 199 -> 0.5
            soSP in 200..399 -> 0.55
            soSP in 400..599 -> 0.6
            else -> 0.65
        }
        return soSP * donGia
    }

    fun hienThiThongTin() {
        println("Họ: $ho")
        println("Tên: $ten")
        println("Số sản phẩm: $soSP")
        println("Lương: ${getLuong()}")
    }

    fun nhapThongTin() {
        print("Nhập họ: ")
        ho = readlnOrNull().orEmpty()

        print("Nhập tên: ")
        ten = readlnOrNull().orEmpty()

        print("Nhập số sản phẩm: ")
        val inputSoSP = readlnOrNull()?.toIntOrNull() ?: 0
        setSoSP(inputSoSP) // Kiểm tra và cập nhật số sản phẩm
    }

    fun lonHon(nv: NhanVien): Boolean {
        return this.soSP > nv.soSP
    }
}





