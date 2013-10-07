<%@ include file="/taglibs.jsp" %>

<stripes:layout-render name="/layout.jsp" title="CandyCrush">

	<stripes:layout-component name="body">
		
		<image src="src/main/webapp/images/candy.jpg"/>
		<h1>Bienvenido a CandyCrush</h1>
		
		<stripes:form beanclass="action.RegistroActionBean" focus="">
		<stripes:errors/>
	
		<table>
			<tr>
				<td>Usuario: </td>
				<td><stripes:text name="nombre"/></td>
				<stripes:errors field="nombre"/>
			</tr>
			<tr>
				<td colspan="2">
               	 	<stripes:submit name="registrar" value="registrar"/>
                  	<stripes:submit name="logear" value="logear"/>                 
               	</td>
			</tr>	
		</table>

		</stripes:form>

	</stripes:layout-component>

</stripes:layout-render>