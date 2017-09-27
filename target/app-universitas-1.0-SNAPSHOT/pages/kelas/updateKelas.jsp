<%-- 
    Document   : addKelas
    Created on : Sep 25, 2017, 2:33:31 PM
    Author     : ADIB PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Kelas</h1>
        <form action="${pageContext.servletContext.contextPath}/kelas/update" method="post">
            <input type="hidden" value="${k.id}" name="kelasId">
            <div>
                <label for="KelasName">Nama Kelas</label>
                <input type="text" name="kelasName" id="kelasName" value="${k.nama}">
            </div>
            <div>
                <label for="KelasAngkatan">Angkatan</label>
                <input type="number" name="kelasAngkatan" id="kelasAngkatan" value="${k.angkatan}">
            </div>
            <div> 
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
            
        </form>
    </body>
</html>
