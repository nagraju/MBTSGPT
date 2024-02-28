package com.example.mbtsgpt.model

data class JwtResponse(val responseUser: User,val jwtToken:String,val message:String)