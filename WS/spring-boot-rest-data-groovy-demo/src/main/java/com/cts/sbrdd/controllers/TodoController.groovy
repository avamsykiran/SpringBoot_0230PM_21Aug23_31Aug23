@RestController
@RequestMapping('todo')
public class TodoController {

    @Autowired
    TodoService todoService

    @GetMapping
    List<Todo> getAllTodoList(){
        todoService.findAll()
    }

    @PostMapping
    Todo saveTodo(@RequestBody Todo todo){
        todoService.saveTodo todo
    }

    @PutMapping
    Todo updateTodo(@RequestBody Todo todo){
        todoService.updateTodo todo
    }

    @DeleteMapping('/{todoId}')
    deleteTodo(@PathVariable Integer todoId){
        todoService.deleteTodo todoId
    }

    @GetMapping('/{todoId}')
    Todo getTodoById(@PathVariable Integer todoId){
        todoService.findById todoId
    }
}