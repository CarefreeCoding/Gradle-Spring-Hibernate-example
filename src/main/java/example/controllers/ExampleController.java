package example.controllers;

import com.google.gson.Gson;
import example.objects.ExampleObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/example")
public class ExampleController
{
	@RequestMapping(value = "/get",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String get()
	{
		System.out.println("Called get");
		return new Gson().toJson(new ExampleObject());
	}

	@RequestMapping(value = "/get/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String get(@PathVariable String id)
	{
		System.out.println("Received |" + id + "|");
		return new Gson().toJson(new ExampleObject());
	}

	@RequestMapping(value = "/add/{name}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String add(@PathVariable String name)
	{
		ExampleObject object = new ExampleObject();
		object.setName(name);
		System.out.println(object);
		return new Gson().toJson(new ExampleObject());
	}
}
