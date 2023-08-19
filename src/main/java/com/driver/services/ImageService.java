package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image = new Image();
        Blog blog = blogRepository2.findById(blogId).get();
        image.setBlog(blog);
        image.setDescription(description);
        image.setDimensions(dimensions);
        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image = imageRepository2.findById(id).get();
        String p = image.getDimensions();
        return  ((Integer.parseInt(screenDimensions.substring(0,screenDimensions.indexOf('X'))))/Integer.parseInt(p.substring(0,p.indexOf('X')))) * (Integer.parseInt(screenDimensions.substring(screenDimensions.indexOf('X')+1,screenDimensions.length()))/Integer.parseInt(p.substring(p.indexOf('X')+1,p.length())));
    }
}
