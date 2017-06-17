/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/stream"})
public final class UpdateGame extends HttpServlet {

    final GameDetails game = new GameDetails();
    //public static Stock stock = new Stock();
    volatile String message;
    

    @Override
    public void init(final ServletConfig config) {
        game.start();
        Logger.getGlobal().log(Level.INFO, "Started stock price updates");
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");

        try (final PrintWriter out = response.getWriter()) {
            //out.println("data: Welcome to the chatroom!");

            while (!Thread.interrupted()) {
                out.println();
                out.flush();
                Logger.getGlobal().log(Level.INFO, "Sent " +game);
                synchronized (this) {
                    wait();
                    out.print("data: ");
                    out.println(game);
                    out.println();
                    out.flush();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getGlobal().log(Level.INFO, "Exiting");
        }
        
        
        
//        response.setContentType("text/event-stream");
//        
//        
//
//        try (final PrintWriter out = response.getWriter()) {
//
//           // while (!Thread.interrupted()) {
//                synchronized (stock) {
//                    stock.wait();
//                }
//                out.print("data:");
//                out.println(stock);
//                out.println();
//                out.flush();
//            //}
//        } catch (InterruptedException e) {
//            throw new ServletException(e);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
//        response.setContentType("text/event-stream");
//        
//        
//
//        
        synchronized (this) {
            message = req.getReader().readLine();
            if(message.equals("ArrowUp")||message.equals("ArrowLeft")||message.equals("ArrowRight")||message.equals("ArrowDown")){
                game.changePosition(message);
 
            notifyAll();
            Logger.getGlobal().log(Level.INFO, "Received " + message);
        }
        }
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }
    
    
    
    @Override
    public void destroy() {
        try {
            game.interrupt();
            game.join();
            Logger.getGlobal().log(Level.INFO, "Stopped stock price updates");

        } catch (InterruptedException e) {
        }
    }
}
