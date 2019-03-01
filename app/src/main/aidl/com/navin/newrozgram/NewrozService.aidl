// NewrozService.aidl
package com.navin.newrozgram;

// Declare any non-default types here with import statements

interface NewrozService {

   void login(String username,String password);
   void register();
   void pay(String cost);


}
