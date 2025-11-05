namespace TestProject1
{
    public class AddFunctionTest
    {

        //Mock function - for testing

        public int Add(int x, int y) { return x + y; }

        //Unit test

        [Test]
        public void Test1()
        {
            Assert.That(Add(1,1), Is.EqualTo(2));
        }

        [Test]
        public void Test2()
        {
            Assert.That(Add(2, 2), Is.EqualTo(4));
        }

        [Test]
        public void Test3()
        {
            Assert.That(Add(-1, 1), Is.EqualTo(0));
        }
    }
}