@Service
class TodoServiceImpl implements TodoService {

    @Autowired
    private todoRepository todoRepository;
    
    @Override
    List<Todo> findAll() {
        todoRepository.findAll()
    }

    @Override
    Todo findById(Integer todoId) {
        todoRepository.findById todoId get()
    }
    
    @Override
    Todo saveTodo(Todo todo){
        todoRepository.save todo
    }
    
    @Override
    Todo updateTodo(Todo todo){
        todoRepository.save todo
    }
    
    @Override
    Todo deleteTodo(Integer todoId){
        todoRepository.deleteById todoId
    }
}