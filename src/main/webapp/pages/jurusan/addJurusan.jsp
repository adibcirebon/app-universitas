<%-- 
    Document   : addJurusan
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
        <h1>Form Jurusan</h1>
        <form action="${pageContext.servletContext.contextPath}/jurusan/new" method="post">
            <div>
                <label for="JurusanName">Nama Jurusan</label>
                <input type="text" name="jurusanName" id="jurusanName">
            </div>
            <div> 
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
            
        </form>
    </body>
</html>
