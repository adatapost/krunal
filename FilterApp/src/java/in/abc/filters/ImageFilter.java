/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.abc.filters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.imageio.ImageIO;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author admin
 */
@WebFilter(filterName = "ImageFilter", urlPatterns = {"/image"})
public class ImageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String text = request.getParameter("text");
        if (text == null) {
            text = "";
        }
        BufferedImage bufferImage = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferImage.getGraphics();
        g.setColor(Color.red);
        g.fillRect(0, 0, 100, 40);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString(text, 25, 25);

        response.setContentType("image/png");
        ImageIO.write(bufferImage, "png", response.getOutputStream());
    }

    @Override
    public void destroy() {

    }

}
