<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link href="style.css" rel="stylesheet" type="text/css">


<table class="center">
<c:forEach begin="0" end="9" var="y">
    <tr>
    <c:forEach begin="0" end="9" var="x">
        <td class="pole pole${pole[x][y]}">
            <c:out value="${pole[x][y]}"/>
        </td>
    </c:forEach>
    </tr>
</c:forEach>
</table>

