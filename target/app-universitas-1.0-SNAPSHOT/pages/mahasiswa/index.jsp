<%-- 
    Document   : index
    Created on : Sep 26, 2017, 10:46:34 AM
    Author     : ADIB PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DAFTAR MAHASISWA</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <td> Kode </td>
                    <td> NIM </td>
                    <td> Nama Mahasiswa </td>
                    <td> Kelas </td>
                    <td> Jurusan </td>
                    <td> Aksi </td>
                </tr> 
            </thead>
            <tbody>
                <c:forEach items="${listMahasiswa}" var="mhs">
                    <tr>
                        <td>${mhs.id}</td>
                        <td>${mhs.nim}</td>
                        <td>${mhs.nama}</td>
                        <td>${mhs.kelas.nama}</td>
                        <td>${mhs.jurusan.nama}</td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
