class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> doubleBookings;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] doubleBooking : doubleBookings) {
            if (start < doubleBooking[1] && end > doubleBooking[0]) {
                return false;
            }
        }
        for (int[] booking : bookings) {
            if (start < booking[1] && end > booking[0]) {
                int overlapStart = Math.max(start, booking[0]);
                int overlapEnd = Math.min(end, booking[1]);
                doubleBookings.add(new int[]{overlapStart, overlapEnd});
            }
        }
        bookings.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */