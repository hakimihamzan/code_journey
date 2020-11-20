import 'package:flutter/material.dart';

class TaskTile extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ListTile(
      title: Text('message received message received '),
      trailing: Checkbox(
        value: false,
      ),
    );
  }
}
