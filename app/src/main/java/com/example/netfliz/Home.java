package com.example.netfliz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
Button Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageSlider imageSlider = findViewById(R.id.slider);

        List<SlideModel>slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://www.google.com/search?sa=X&rlz=1C1CHWL_enIN909IN909&sxsrf=ALeKk03jlPH4-o07BKGzyPrdXUbIvbbwVA:1611151103065&source=univ&tbm=isch&q=movie+poster&hl=en&ved=2ahUKEwjYs7XJ1aruAhVSXHwKHVzbA4sQ7Al6BAgDEFU&biw=1707&bih=781#imgrc=qjvq7DCnSXM4AM","Movie 1"));
        slideModels.add(new SlideModel("https://www.google.com/search?q=iron+man&tbm=isch&ved=2ahUKEwiP84eI1qruAhViD7cAHRSBDecQ2-cCegQIABAA&oq=iron+man&gs_lcp=CgNpbWcQARgAMgQIIxAnMgcIABCxAxBDMgcIABCxAxBDMgUIABCxAzIHCAAQsQMQQzIFCAAQsQMyBAgAEEMyBwgAELEDEEMyBAgAEEMyBQgAELEDOgIIAFC4LViGQmCCU2gBcAB4AIABrgGIAYEGkgEDMC42mAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=gjcIYI-qGuKe3LUPlIK2uA4&bih=781&biw=1707&rlz=1C1CHWL_enIN909IN909&hl=en","Movie 2"));
        slideModels.add(new SlideModel("https://www.google.com/search?q=spiderman&tbm=isch&ved=2ahUKEwiPtNSN1qruAhXhALcAHamrBhIQ2-cCegQIABAA&oq=spi&gs_lcp=CgNpbWcQARgAMgQIABBDMgcIABCxAxBDMgcIABCxAxBDMgcIABCxAxBDMgcIABCxAxBDMgcIABCxAxBDMgcIABCxAxBDMgcIABCxAxBDMgQIABBDMgQIABBDOgQIIxAnOgUIABCxAzoHCCMQ6gIQJ1CWuQFYx8gBYOLaAWgBcAB4A4ABqwGIAZMKkgEEMC4xMJgBAKABAaoBC2d3cy13aXotaW1nsAEKwAEB&sclient=img&ei=jjcIYI-1CuGB3LUPqdeakAE&bih=781&biw=1707&rlz=1C1CHWL_enIN909IN909&hl=en","Movie 3"));
        slideModels.add(new SlideModel("https://www.google.com/search?q=batman&tbm=isch&ved=2ahUKEwjDyLub1qruAhUiz3MBHcfzCH4Q2-cCegQIABAA&oq=bat&gs_lcp=CgNpbWcQARgCMgQIIxAnMgQIIxAnMgcIABCxAxBDMgcIABCxAxBDMgcIABCxAxBDMgQIABBDMgQIABBDMgQIABBDMgQIABBDMgQIABBDOgUIABCxAzoHCCMQ6gIQJ1D7hQFYg5UBYJKnAWgBcAB4A4ABlgGIAZcKkgEEMC4xMZgBAKABAaoBC2d3cy13aXotaW1nsAEKwAEB&sclient=img&ei=qzcIYIPHB6Kez7sPx-ej8Ac&bih=781&biw=1707&rlz=1C1CHWL_enIN909IN909&hl=en","Movie 4"));
          Logout = findViewById(R.id.logout);

          Logout.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                          openlog();
                      }

                      public void openlog(){
                          Intent intent = new Intent(Home.this, MainActivity.class);
                          startActivity(intent);
              }
          });
    }
}
