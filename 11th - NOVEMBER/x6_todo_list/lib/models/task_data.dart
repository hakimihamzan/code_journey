import 'package:flutter/foundation.dart';
import 'package:todoey_flutter/models/task.dart';

class TaskData extends ChangeNotifier {
  List<Task> tasks = [
    Task(name: 'Buy milk'),
    Task(name: 'Buy eggs'),
    Task(name: 'Go to the gym'),
    Task(name: 'Watch Jujutsu Kaisen'),
    Task(name: "goto solleep"),
    Task(name: "pew"),
  ];

  int get taskCount => tasks.length;
}
