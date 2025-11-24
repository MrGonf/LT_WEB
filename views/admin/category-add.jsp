<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/commons/taglib.jsp"%>

<style>
.img-auto {
    width: 100%;
    height: auto;
    max-width: 250px;
    max-height: 180px;
    object-fit: contain;
    border: 1px solid #ccc;
    padding: 4px;
}
</style>

<form action="${pageContext.request.contextPath}/admin/categories/insert"
      method="post" enctype="multipart/form-data">

    <label for="categoryname">Category name:</label><br>
    <input type="text" id="categoryname" name="categoryname"><br>

    <label>Images:</label><br>

    <!-- Ảnh preview duy nhất -->
    <img id="previewImg" class="img-auto" src=""><br>


    <label>Tải ảnh (tùy chọn):</label><br>
    <input type="file" id="imageUpload" name="images" onchange="previewFile(this)"><br>
    
    <label>Nhập link ảnh (tùy chọn):</label>
    <input type="text" id="imageLink" name="images1"><br>
    
    <label for="status">Status:</label>
    <input id="statuson" type="radio" name="status" value="1">
    <label for="statuson">Hoạt động</label>

    <input id="statusoff" type="radio" name="status" value="0">
    <label for="statusoff">Khóa</label>
    <br><br>

    <input type="submit" value="Submit">
</form>

<script>
    // Preview file upload
    function previewFile(input) {
        if (input.files && input.files[0]) {
            const reader = new FileReader();
            reader.onload = (e) => {
                document.getElementById("previewImg").src = e.target.result;
            };
            reader.readAsDataURL(input.files[0]);
        }
    }

    // Preview link ảnh
    document.getElementById("imageLink").addEventListener("keyup", function () {
        const url = this.value.trim();
        if (url.startsWith("http")) {
            document.getElementById("previewImg").src = url;
        }
    });
</script>
