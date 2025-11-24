<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/commons/taglib.jsp"%>


<a href="${pageContext.request.contextPath}/admin/categories/add">Add Category</a>

<style>
.img-auto {
    width: 100%;
    height: auto;
    max-width: 250px;
    max-height: 180px;
    object-fit: contain;
}
</style>

<table border="1" width="100%">
    <tr>
        <th>STT</th>
        <th>Images</th>
        <th>CategoryID</th>
        <th>CategoryName</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${listcate}" var="cate" varStatus="st">
        <tr>
            <td>${st.index + 1}</td>

            <td>
                <c:choose>
                    <c:when test="${fn:startsWith(cate.images, 'http')}">
                        <img class="img-auto" src="${cate.images}" />
                    </c:when>
					<c:otherwise>
						<c:url var="imgUrl" value="/image">
							<c:param name="fname" value="${cate.images}" />
						</c:url>
						<img class="img-auto" src="${imgUrl}" />
					</c:otherwise>
				</c:choose>
            </td>

			<td>${cate.categoryId}</td>
            <td>${cate.categoryname}</td>

            <td>
                <c:if test="${cate.status == 1}">
                    <span>Hoạt động</span>
                </c:if>
                <c:if test="${cate.status != 1}">
                    <span>Khóa</span>
                </c:if>
            </td>

            <td>
                <c:url var="editUrl" value="/admin/categories/edit">
                    <c:param name="id" value="${cate.categoryId}" />
                </c:url>

                <c:url var="deleteUrl" value="/admin/categories/delete">
                    <c:param name="id" value="${cate.categoryId}" />
                </c:url>

                <a href="${editUrl}">Sửa</a> | <a href="${deleteUrl}" onclick="return confirm('Bạn có chắc muốn xóa không?')">Xóa</a>
                
            </td>
        </tr>
    </c:forEach>
</table>

