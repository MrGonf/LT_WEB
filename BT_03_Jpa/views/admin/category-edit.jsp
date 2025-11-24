<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

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

<form action="${pageContext.request.contextPath}/admin/categories/update"
      method="post" enctype="multipart/form-data">

    <input type="hidden" name="categoryid" value="${cate.categoryId}">

    <label>Category name:</label><br>
    <input type="text" name="categoryname" value="${cate.categoryname}"><br>

    <label>Ảnh hiện tại:</label><br>

    <!-- CHỈ 1 IMG DUY NHẤT -->
    <c:choose>
        <c:when test="${fn:startsWith(cate.images, 'http')}">
            <img class="img-auto" src="${cate.images}" id="preview">
        </c:when>
        <c:otherwise>
            <c:url var="imgUrl" value="/image">
                <c:param name="fname" value="${cate.images}" />
            </c:url>
            <img class="img-auto" src="${imgUrl}" id="preview">
        </c:otherwise>
    </c:choose>

    <br><br>

    <label>Tải ảnh mới (tùy chọn):</label><br>
	<input type="file" id="imageUpload" name="images" onchange="previewFile(this)"> <br>
	<img id="previewImg" class="img-auto" src ="">
	<br>

    <label>Nhập link ảnh (tùy chọn):</label>
    <input type="text" id="imageLink" name="images1" placeholder="https://..."><br>

    <label>Status:</label>
    <input type="radio" name="status" value="1" ${cate.status == 1 ? "checked" : ""}> Hoạt động
    <input type="radio" name="status" value="0" ${cate.status == 0 ? "checked" : ""}> Khóa
    <br><br>

    <input type="submit" value="Submit">
</form>

<script>
    // Preview file upload
		function previewFile(input) {
		    if (input.files && input.files[0]) {
		        const reader = new FileReader();
		        reader.onload = function(e) {
		            document.getElementById("previewImg").src = e.target.result;
		        };
		        reader.readAsDataURL(input.files[0]);
		    }
		}

    // Preview link nhập vào
    document.getElementById("imageLink").addEventListener("keyup", function () {
        const url = this.value.trim();
        if (url.startsWith("http")) {
            document.getElementById("previewImg").src = url;
        }
    });
</script>
