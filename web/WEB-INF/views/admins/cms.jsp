<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<%@ include file="../../layouts/admin_head.jsp"%>

<body>

<div id="wrapper">

    <%@ include file="../../layouts/admin_menu.jsp"%>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">CMS Page</h1>

                <button class="btn btn-success add-edit-btn" href="#demo" data-toggle="collapse">ADD/Edit Content</button>
                <div id="demo" class="collapse">
                   <form class="form-group" id="cms-form">
                       <input type="hidden" name="id" id="c_id">
                       <label>Title</label><input type="text" name="title" id="title" class="form-control">
                       <label>Slug</label><input type="text"  name="title" id="slug" class="form-control">
                       <label>Description</label><textarea name="description" id="description" class="form-control" placeholder="Your Description here"></textarea>

                       <input type="submit" name="submit" value="submit" class="btn btn-success" id="cmsSubmit">
                   </form>
                </div>
                <table class="table table-hover" id="cms-table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Slug</th>
                        <th>Description</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cms}" var="cm">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <tr id="<c:out value="${cm.id}" />">
                            <td><c:out value="${count}"/></td>
                            <td><c:out value="${cm.title}" /></td>
                            <td><c:out value="${cm.slug}" /></td>
                            <td><c:out value="${cm.description}" /></td>
                            <td><button class="btn btn-primary btn-xs edit-btn" value="${cm.id}" ><i class="fa fa-edit"></i></button>
                                <button class="btn btn-danger btn-xs delete-btn" value="${cm.id}"><i class="fa fa-trash-o"></i></button></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>




            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
<%@ include file="../../layouts/admin_footer.jsp"%>
<script src="<c:url value="/assets/js/cms.js"/>"></script>
<script src="https://cdn.tiny.cloud/1/ez4ww70xx27n20g2ot7b45idx4is10zay7oafs1p5l4lit8h/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
<%--<script>--%>
<%--tinymce.init({--%>
<%--    selector: '#description'--%>
<%--});--%>
<%--</script>--%>
<%--<script>--%>
<%--    tinymce.init({--%>
<%--        selector: 'textarea',--%>
<%--        plugins: 'a11ychecker advcode casechange formatpainter linkchecker autolink lists checklist media mediaembed pageembed permanentpen powerpaste table advtable tinycomments tinymcespellchecker',--%>
<%--        toolbar: 'a11ycheck addcomment showcomments casechange checklist code formatpainter pageembed permanentpen table',--%>
<%--        toolbar_mode: 'floating',--%>
<%--        tinycomments_mode: 'embedded',--%>
<%--        tinycomments_author: 'Author name',--%>
<%--    });--%>
<%--    // ez4ww70xx27n20g2ot7b45idx4is10zay7oafs1p5l4lit8h--%>
<%--</script>--%>
</body>

</html>