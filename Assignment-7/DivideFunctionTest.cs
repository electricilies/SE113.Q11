namespace TestProject1
{
    public class DivideFunctionTest
    {

        //Mock function - for testing

        public double Divide(int a, int b)
        {
            if (b == 0) throw new ArgumentException("Divider cannot be zero");
            return (double)a / b;
        }

        //Unit test

        [Test]
        public void Test1()
        {
            Exception exception = Assert.Throws<ArgumentException>(() => Divide(5, 0));
            Assert.That(exception.Message, Is.EqualTo("Divider cannot be zero"));
        }

        [Test]
        public void Test2()
        {
            Assert.That(Divide(6, 2), Is.EqualTo(3.0));
        }
    }
}
