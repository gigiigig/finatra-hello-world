package com.twitter.hello

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class HelloWorldController extends Controller {

  get("/hi") { request: Request =>
    "<div>I'm not implemented yet</div>"
  }

  get("/payload") { request: Request =>
    val lp: List[Person] = (1 to 100).toList.map { i =>
      val address = Address("foo", i, "house")
      val contact = Contact("134567654", "l@i.it")
      Person(s"name$i", i, address, contact)
    }
    lp
  }
}

case class Address(street: String, number: Int, house: String)
case class Contact(phoneNumber: String, email: String)
case class Person(name :String, age: Int, address: Address, contact: Contact)
