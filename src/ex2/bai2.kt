package ex2

import java.util.Scanner
import kotlin.math.PI

// Lớp Point đại diện cho tọa độ (x, y)
open class Point(var x: Double, var y: Double) {
    override fun toString(): String {
        return "[$x, $y]"
    }
}

// Lớp Circle kế thừa từ Point
class Circle(x: Double, y: Double, private var radius: Double) : Point(x, y) {

    init {
        setRadius(radius)
    }

    // Phương thức kiểm tra và đặt giá trị bán kính
    fun setRadius(radius: Double) {
        if (radius > 0) {
            this.radius = radius
        } else {
            println("Bán kính không hợp lệ! Mặc định là 1.0")
            this.radius = 1.0
        }
    }

    // Lấy bán kính
    fun getRadius(): Double {
        return radius
    }

    // Tính đường kính hình tròn
    fun getDiameter(): Double {
        return 2 * radius
    }
    // Tính chu vi hình tròn
    fun getCircumference(): Double {
        return 2 * PI * radius
    }
    // Tính diện tích hình tròn
    fun getArea(): Double {
        return PI * radius * radius
    }
    override fun toString(): String {
        return "Circle tại tọa độ ${super.toString()} với bán kính $radius"
    }
}
// Hàm main()
fun main() {
    val scanner = Scanner(System.`in`)
    print("Nhập số lượng hình tròn: ")
    val n = scanner.nextInt()
    val circles = mutableListOf<Circle>()
    // Nhập dữ liệu cho n hình tròn
    for (i in 1..n) {
        print("Nhập tọa độ x của hình tròn thứ $i: ")
        val x = scanner.nextDouble()
        print("Nhập tọa độ y của hình tròn thứ $i: ")
        val y = scanner.nextDouble()
        print("Nhập bán kính của hình tròn thứ $i: ")
        val radius = scanner.nextDouble()
        circles.add(Circle(x, y, radius))
    }
    // Xuất thông tin đường kính, chu vi, diện tích của từng hình tròn
    println("\nThông tin các hình tròn:")
    for (circle in circles) {
        println("${circle.toString()}")
        println("  Đường kính: %.2f".format(circle.getDiameter()))
        println("  Chu vi: %.2f".format(circle.getCircumference()))
        println("  Diện tích: %.2f".format(circle.getArea()))
    }
    scanner.close()
}
