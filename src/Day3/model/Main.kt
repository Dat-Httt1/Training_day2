package Day3.model

import Day3.model.OfficeStaff
import Day3.model.ProductionStaff

fun enterProductionStaff(): ProductionStaff{
    print("Nhập họ nhân viên sản xuất: ")
    val firstName = readlnOrNull().orEmpty()
    print("Nhập tên nhân viên sản xuất: ")
    val lastName = readlnOrNull().orEmpty()
    print("Nhập lương cơ bản nhân viên sản xuất: ")
    val basicSalary = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    print("Nhập số sản phẩm: ")
    val countProduct = readlnOrNull()?.toIntOrNull() ?: 0

    return ProductionStaff(firstName, lastName, basicSalary, countProduct)
}

fun enterOfficeStaff(): OfficeStaff{
    print("Nhập họ nhân viên văn phòng: ")
    val firstName = readlnOrNull().orEmpty()
    print("Nhập tên nhân viên văn phòng: ")
    val lastName = readlnOrNull().orEmpty()
    print("Nhập lương cơ bản nhân viên văn phòng: ")
    val basicSalary = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    print("Nhập số ngày làm việc: ")
    val countWorkingDay = readlnOrNull()?.toIntOrNull() ?: 0

    return OfficeStaff(firstName, lastName, basicSalary, countWorkingDay)
}

fun main() {
    val nvSanXuat = enterProductionStaff()

    val nvVanPhong = enterOfficeStaff()

    println("\n===== Kết quả =====")
    println(nvSanXuat.getSalary())
    println(nvVanPhong.getSalary())

    if (nvSanXuat.caculateSalary() > nvVanPhong.caculateSalary()) {
        println("${nvSanXuat.getFullName()} có lương cao hơn ${nvVanPhong.getFullName()} (${nvSanXuat.caculateSalary() - nvVanPhong.caculateSalary()} VND)")
    } else if (nvVanPhong.caculateSalary() > nvSanXuat.caculateSalary()) {
        println("${nvVanPhong.getFullName()} có lương cao hơn ${nvSanXuat.getFullName()} (${nvVanPhong.caculateSalary() - nvSanXuat.caculateSalary()} VND)")
    } else {
        println("Cả hai nhân viên có mức lương bằng nhau.")
    }
}