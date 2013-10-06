<%@ include file="/taglibs.jsp" %>

<stripes:layout-render name="/layout.jsp" title="home">

	<stripes:layout-component name="body">

		<input name="candycrush" type="image" src="/resources/candy.jpg" />
		<h1>Bienvenido a CandyCrush</h1>

		<stripes:form beanclass="action.RegistroActionBean"  focus="">
		
		<table>
			<tr>
				<td>Usuario: </td>
				<td><stripes:text name="nombre"/>
			</tr>
			<tr>
				<td colspan="2">
                    <stripes:submit name="registrar" value="Registrar"/>                    
                </td>
			</tr>
			<tr>
				<td colspan="2">
                    <stripes:submit name="logear" value="Logear"/>                    
                </td>
			</tr>
		</table>

		</stripes:form>

	</stripes:layout-component>

</stripes:layout-render>