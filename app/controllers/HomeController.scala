package controllers

import javax.inject._

import models.{AppDatabase, User}
import play.api._
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def beers(style: String) = Action.async {
    AppDatabase.beers.getByStyle(style).map { beers =>
      Ok(views.html.beers(style, beers))
    }
  }

  val user = new User("32", "2", "3", "4", "5", "3")
  def store() = Action.async{
    Future {
      AppDatabase.users.store(user)
      Ok("")
    }
  }

  def c() = Action.async{
    Future{
      AppDatabase.users.creat()
      Ok("")
    }
  }
}
