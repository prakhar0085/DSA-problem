class StockSpanner {
    private Stack<Integer> stack;
    private List<Integer> prices;

    public StockSpanner() {
        stack = new Stack<>();
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        prices.add(price);

        int currentIndex = prices.size()-1;
        while(!stack.isEmpty() && prices.get(stack.peek()) <= price){
            stack.pop();
        }

        //calculate span 
        int span;
        if(stack.isEmpty()){
            span = currentIndex + 1;
        }else{
            span = currentIndex - stack.peek();
        }
        stack.push(currentIndex);
        return span;


        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */