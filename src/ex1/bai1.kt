package ex1

data class Category(
    val id: String,
    val name: String,
    val products: MutableList<Product> = mutableListOf())
data class Product(
    var id: String,
    var name: String,
    var price: Double,
    var origin: String)
val categories = mutableListOf<Category>()
fun addCategory() {
    print("Nhập mã danh mục: ")
    val id = readLine()!!.trim()
    print("Nhập tên danh mục: ")
    val name = readLine()!!.trim()
    categories.add(Category(id, name))
}
fun addProduct() {
    print("Nhập mã danh mục chứa sản phẩm: ")
    val categoryId = readLine()!!.trim()
    val category = categories.find { it.id == categoryId }
    if (category != null) {
        print("Nhập mã sản phẩm: ")
        val id = readLine()!!.trim()
        print("Nhập tên sản phẩm: ")
        val name = readLine()!!.trim()
        print("Nhập giá sản phẩm: ")
        val price = readLine()!!.toDouble()
        print("Nhập xuất xứ: ")
        val origin = readLine()!!.trim()
        category.products.add(Product(id, name, price, origin))
    } else {
        println("Danh mục không tồn tại!")
    }
}
fun showProductsByCategory() {
    print("Nhập mã danh mục cần xem sản phẩm: ")
    val categoryId = readLine()!!.trim()
    val category = categories.find { it.id == categoryId }
    if (category != null) {
        println("Danh sách sản phẩm thuộc danh mục ${category.name}:")
        category.products.forEach { println(it) }
    } else {
        println("Danh mục không tồn tại!")
    }
}
fun updateProduct() {
    print("Nhập mã sản phẩm cần cập nhật: ")
    val productId = readLine()!!.trim()
    for (category in categories) {
        val product = category.products.find { it.id == productId }
        if (product != null) {
            print("Nhập tên mới: ")
            product.name = readLine()!!.trim()
            print("Nhập giá mới: ")
            product.price = readLine()!!.toDouble()
            print("Nhập xuất xứ mới: ")
            product.origin = readLine()!!.trim()
            println("Cập nhật thành công!")
            return
        }
    }
    println("Không tìm thấy sản phẩm!")
}
fun deleteProduct() {
    print("Nhập mã sản phẩm cần xóa: ")
    val productId = readLine()!!.trim()
    for (category in categories) {
        if (category.products.removeIf { it.id == productId }) {
            println("Xóa sản phẩm thành công!")
            return
        }
    }
    println("Không tìm thấy sản phẩm!")
}

fun totalValue() {
    val total = categories.sumOf { it.products.sumOf { product -> product.price } }
    println("Tổng giá trị hàng hóa: $total")
}

fun listChineseProducts() {
    val chineseProducts = categories.flatMap { it.products }.filter { it.origin.equals("Trung Quốc", true) }
    if (chineseProducts.isNotEmpty()) {
        println("Danh sách sản phẩm có xuất xứ từ Trung Quốc:")
        chineseProducts.forEach { println(it) }
    } else {
        println("Không có sản phẩm nào từ Trung Quốc.")
    }
}

fun main() {
    while (true) {
        println("\nMenu quản lý sản phẩm:")
        println("1. Thêm danh mục sản phẩm")
        println("2. Thêm sản phẩm")
        println("3. Hiển thị sản phẩm theo danh mục")
        println("4. Cập nhật sản phẩm")
        println("5. Xóa sản phẩm")
        println("6. Tính tổng giá trị hàng hóa")
        println("7. Liệt kê sản phẩm có xuất xứ từ Trung Quốc")
        println("8. Thoát")
        print("Chọn chức năng: ")
        when (readLine()!!.toInt()) {
            1 -> addCategory()
            2 -> addProduct()
            3 -> showProductsByCategory()
            4 -> updateProduct()
            5 -> deleteProduct()
            6 -> totalValue()
            7 -> listChineseProducts()
            8 -> return
            else -> println("Chọn không hợp lệ!")
        }
    }
}
