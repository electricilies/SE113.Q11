namespace TestProject1
{
    public class GetEvenNumberTest
    {
        //Mock function - for testing
        public int[] GetEvenNumbers(int[] arr)
        { return arr.Where(x => x % 2 == 0).ToArray(); }

        //Unit test

        [Test]
        public void Test1()
        {
            List<int> arr = new List<int>();
            arr.Add(2);
            arr.Add(4);
            Assert.That(arr, Is.EqualTo(GetEvenNumbers([1, 2, 3, 4, 5])));
        }

        [Test]
        public void Test2()
        {
            List<int> arr = new List<int>();
            Assert.That(arr, Is.EqualTo(GetEvenNumbers([])));
        }
    }
}
