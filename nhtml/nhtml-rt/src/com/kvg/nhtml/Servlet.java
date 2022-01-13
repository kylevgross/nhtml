package com.kvg.nhtml;


import javax.baja.collection.BITable;
import javax.baja.collection.ColumnList;
import javax.baja.collection.TableCursor;
import javax.baja.naming.BOrd;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.baja.user.BUser;
import javax.baja.sys.*;



@SuppressWarnings("serial")


public class Servlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        BUser user = BUser.getCurrentAuthenticatedUser();
        String homePage = user.getHomePage().toString();
        String navFile = user.getNavFile().toString();


        String folderPath = "";
        String defaultPath = "station:|slot:/";


        System.out.println("HTML5Service - authenticated user: " + user);




        if (homePage.equals(defaultPath) || homePage.equals("null"))  {
            resp.getWriter().write(String.format("Error! User nav file not properly set - refer to nhtml documentation"));
            System.out.println("Homepage not properly set");

        }

        else if (path.equals("/")) {
            int pathLength = homePage.length();

            int endPath = pathLength - 17;
            String serviceName = homePage.substring(24,endPath);
            BOrd query = BOrd.make("station:|slot:/|bql:select htmlFolder as 'folderPath' from nhtml:HTML5 where name = '" + serviceName + "'");



        BITable table = (BITable) query.get();
        ColumnList columns = table.getColumns();

        try (TableCursor<BIObject> cursor = table.cursor()) {


            while (cursor.next()) {


                folderPath = (cursor.cell(columns.get(0)).toString());

                System.out.println("HTML5Service - folder path: " + folderPath);


            }


        }
        String urlPath = folderPath.substring(6);


            resp.sendRedirect("/file/" + urlPath + "/index.html");
        }

        }
    }
