import unittest
import sys
import os
sys.path.insert(0, os.path.abspath('..'))
from mapper.teamMapper import TeamMapper
from domain.team import Team
from domain.project import Project

class TeamMapperTest(unittest.TestCase):
    def setUp(self):
        self.teamMapper = TeamMapper()

    def testFind(self):
        rs = self.teamMapper.find(1)
        self.assertIsInstance(rs,  Team)
        self.assertEqual(rs.team_id, 1)
        self.assertIsInstance(rs.project , Project)
        self.assertEqual(rs.project.project_id, rs.project_id)

if __name__ == "__main__":
    unittest.main()
