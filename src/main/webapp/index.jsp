<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link href="style.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
    <table class="center">
    <c:forEach begin="0" end="9" var="y">
        <tr>
            <c:forEach begin="0" end="9" var="x">
                <td class="pole pole${pole[x][y]}" onclick="fire(${x},${y})">

                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
    <script>
        function fire(x,y){
            axios({
                url:'/fire?x='+y+"&y="+x
                }
            ).then(function (response) {
                location.reload();
            })
        }
    </script>
</body>
</html>



