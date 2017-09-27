


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Daftar Jurusan</h1>
        <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Kode</th>
                <th>Nama</th>
                <th>Aksi</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listJurusan}" var="j" varStatus="index">
            <tr>
                <td>${index.count}</td>  
                <td>${j.id}</td>
                <td>${j.nama}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/jurusan/update?id=${j.id}">Edit </a>
                    &nbsp;
                    <!--<form action="${pageContext.servletContext.contextPath}/kelas/delete" method="post">
                        <input type="hidden" name="kelasId" value="${k.id}">
                        <button type="submit">Hapus</button>
                        </input>
                    </form>-->
                        <a href="${pageContext.servletContext.contextPath}/jurusan/delete?jurusanId=${j.id}"}>Hapus</a>
                    
                </td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
    </body>
</html>

