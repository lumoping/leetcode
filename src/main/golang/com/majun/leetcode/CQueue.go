package leetcode

import "container/list"

type CQueue struct {
	stack, reverseStack *list.List
}

func Constructor() CQueue {
	return CQueue{
		stack:        list.New(),
		reverseStack: list.New(),
	}
}

func (this *CQueue) AppendTail(value int) {
	this.stack.PushBack(value)
}

func (this *CQueue) DeleteHead() int {
	if this.reverseStack.Len() == 0 {
		for this.stack.Len() > 0 {
			this.reverseStack.PushBack(this.stack.Remove(this.stack.Back()))
		}
	}
	if this.reverseStack.Len() != 0 {
		head := this.reverseStack.Back()
		this.reverseStack.Remove(head)
		return head.Value.(int)
	}
	return -1
}
